import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        Stopwatch sw = new Stopwatch();
        int N = 1000;
        AList<Integer> a = new AList();
        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Integer> Ns = new ArrayList<>();
        double time = 0;
        for(int i = 1; i < 128001; i++) {
            a.addLast(i);
            if(i == N) {
                time = sw.elapsedTime();
                Ns.add(N);
                times.add(time);
                N = 2*N;
            }
        }
        printTimingTable(Ns, times, Ns);
    }
}
