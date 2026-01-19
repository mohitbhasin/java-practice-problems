package stream;

import lambdaExpression.MethodReference;

public class Main_Stream {
    public static void main(String[] args) {
        System.out.println("---------Introduction---------");
        Introduction.main(null);
        System.out.println("---------Filtering---------");
        Filtering.main(null);
        System.out.println("---------Mapping---------");
        Mapping.main(null);
        System.out.println("---------Method Reference---------");
        MethodReference.main(null);
        System.out.println("---------Optional Object---------");
        OptionalObject.main(null);
        System.out.println("---------Slicing Operations---------");
        SlicingOperations.main(null);
        System.out.println("---------Matching Operations---------");
        MatchingOperations.main(null);
        System.out.println("---------Finding Operations---------");
        FindingOperations.main(null);
        System.out.println("---------Immutable Reduction---------");
        ImmutableReduction.main(null);
        System.out.println("---------Collectors: Mutable Reductions---------");
        MutableReductionsUsingCollectors.main(null);
        System.out.println("---------Collectors: Aggregation Operations---------");
        AggregationOperations.main(null);
        System.out.println("---------Collectors: Grouping By---------");
        GroupingByOperations.main(null);
        System.out.println("---------Parallel Streams---------");
        ParallelStreams.main(null);
        System.out.println("---------Lazy Evaluation---------");
        LazyEvaluation.main(null);
    }
}
