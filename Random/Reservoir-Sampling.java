public class ReservoirSamplingTest {

    private int[] pool; // 所有数据
    private final int N = 100000; // 数据规模
    private Random random = new Random();

    @Before
    public void setUp() throws Exception {
        // 初始化
        pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }
    }

    private int[] sampling(int K) {
        int[] result = new int[K];
        for (int i = 0; i < K; i++) { // 前 K 个元素直接放入数组中
            result[i] = pool[i];
        }

        for (int i = K; i < N; i++) { // K + 1 个元素开始进行概率采样
            int r = random.nextInt(i + 1);//从前i + 1个元素中选K个出来。
            if (r < K) {
                result[r] = pool[i];
            }
        }

        return result;
    }

    @Test
    public void test() throws Exception {
        for (int i : sampling(100)) {
            System.out.println(i);
        }
    }
}
