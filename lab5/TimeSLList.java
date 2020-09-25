import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int N = 1000;
        SLList<Integer> s = new SLList();
        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Integer> Ns = new ArrayList<>();
        ArrayList<Integer> ops = new ArrayList<>();
        double time = 0;
        for(int i = 1; i < 128001; i++) {
            s.addLast(i);
            if(i == N) {
                Stopwatch sw = new Stopwatch();
                for (int j = 0; j< 10000; j++){
                    s.getLast();
                }
                time = sw.elapsedTime();
                Ns.add(N);
                times.add(time);
                ops.add(10000);
                N = 2*N;
            }
        }
        printTimingTable(Ns, times, ops);
    }
}
