package gyliarde.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Reference https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
 */

public class OracleExample {

    // Approach level 1 before java 5
    private static int somaIterator1(List list) {
        Iterator it = list.iterator();
        int soma = 0;
        while (it.hasNext()) {
            int num = (int) it.next();
            if (num % 2 == 0) {
                soma += num;
            }
        }
        return soma;
    }

    // Approach level 2 after java 5
    private static int somaIterator2(List<Integer> list) {
        int soma = 0;
        for (int num : list) {
            if (num % 2 == 0) {
                soma += num;
            }
        }
        return soma;
    }

    private List<Order> orders;
    private List<Order> activatedOrders;

    @Before
    public void setup() {
        orders = Arrays.asList(
                new Order(TypeOrder.ACTIVATED,190,1),
                new Order(TypeOrder.CANCELED,13,2),
                new Order(TypeOrder.ACTIVATED,125,3),
                new Order(TypeOrder.CANCELED,20,4),
                new Order(TypeOrder.ACTIVATED,75,5)
        );

        activatedOrders = new ArrayList<>();
    }


    private void sortedOrder() {
        for(Order o: orders){
            if(o.getType() == TypeOrder.ACTIVATED) {
                activatedOrders.add(o);
            }
        }

        Collections.sort(activatedOrders);

        List<Integer> ordersIDs = new ArrayList<>();

        for(Order o: activatedOrders){
            ordersIDs.add(o.getId());
        }

        System.out.println(ordersIDs);
    }

    public void sortedOrdersWithStream() {
        // Method Reference
        // sorted =  order -> order.getValue is equal to Order::getValue
        // map = order -> order.getId is equal to Order::getId

        List<Integer> list = orders.stream()
                .filter(order -> order.getType() == TypeOrder.ACTIVATED)
                .sorted(Comparator.comparing(Order::getValue).reversed())
                .map(Order::getId)
                .collect(Collectors.toList());

        System.out.println(list);
    }

    @Test
    public void shouldSortedActivatedOrdersWithoutStream() {
        sortedOrder();
    }

    @Test
    public void shouldSortedActivatedOrdersWithSteam() {
        sortedOrdersWithStream();
    }

    /** Intermediary operation of Stream API*/

    /** Filter */

    @Test
    public void shouldHandleFilter() {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        List<Pessoa> pessoasDoBrasil  = pessoas.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toList());
        System.out.println(pessoasDoBrasil);
    };

    /** Map */

    @Test
    public void shouldHandleMap() {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        IntStream iDadeDasPessoasDoBrasil  = pessoas.stream()
                .filter(pessoa -> pessoa.getNacionalidade()
                        .equals("Brasil"))
                .mapToInt(Pessoa::getIdade);
        iDadeDasPessoasDoBrasil.forEach(System.out::println);
    };

    /** Sorted */

    @Test
    public void shouldHandleSorted() {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        List<Pessoa> pessoasComOrdenacao  = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .collect(Collectors.toList());
        System.out.println(pessoasComOrdenacao);
    };

    /** Distinct */

    @Test
    public void shouldHandleDistinct() {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        List<Pessoa> pessoalDistintas  = pessoas.stream().distinct().collect(Collectors.toList());
        System.out.println(pessoalDistintas);
    };

    /** AllMatch */

    @Test
    public void shouldHandleAllMatch() {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        boolean todosMexicanos = pessoas.stream().allMatch(pessoa -> pessoa.getNacionalidade().equals("Mexico"));
        System.out.println(todosMexicanos);
    };
}
