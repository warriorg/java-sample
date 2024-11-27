package me.warriorg.junit;

import java.util.concurrent.TimeUnit;

import cn.hutool.core.bean.BeanUtil;
import me.warriorg.model.DataDTO;
import net.sf.cglib.beans.BeanCopier;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Fork(1) // Fork 1个进程进行测试
@BenchmarkMode(Mode.Throughput) // 吞吐量
@Warmup(iterations = 3) // JIT预热
@Measurement(iterations = 10, time = 1) // 迭代10次,每次1s
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 结果所使用的时间单位
@Threads(10)
public class BeanCopyTest {

    /**
     * 作用域为本次JMH测试，线程共享
     * <p>
     * 初始化source数据集
     */
    @State(Scope.Benchmark)
    public static class GenerateModel {
        DataDTO dto;

        // 初始化
        @Setup(Level.Trial)
        public void prepare() {
            dto = new DataDTO();
//            dto.setName("test");
        }
    }

    /**
     * 初始化BeanCopier
     */
    @State(Scope.Benchmark)
    public static class BeanCopierInit {
        BeanCopier copier;

        @Setup(Level.Trial)
        public void prepare() {
            copier = BeanCopier.create(DataDTO.class, DataDTO.class, false);
        }
    }


    /**
     * get/set 基准测试
     *
     * @return target
     * @throws Exception
     */
    @Benchmark
    public DataDTO testGetSet(GenerateModel generateModel){
        DataDTO data  = new DataDTO();
//        data.setName(generateModel.dto.getName());
        return data;
    }

    /**
     * Hutool BeanUtil基准测试
     *
     * @param generateModel source
     * @return target
     * @throws Exception
     */
    @Benchmark
    public DataDTO testHutoolBeanUtil(GenerateModel generateModel){
        return BeanUtil.copyProperties(generateModel.dto, DataDTO.class);
    }

//    /**
//     * Hutool CglibUtil基准测试
//     * 17 cglib 报错
//     *
//     * @param generateModel source
//     * @return target
//     * @throws Exception
//     */
//    @Benchmark
//    public DataDTO testHutoolCglibUtil(GenerateModel generateModel){
//        return CglibUtil.copy(generateModel.dto, DataDTO.class);
//    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BeanCopyTest.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}
