package customlist;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomListTest {

    private final CustomList tut = new CustomList();

    @Test
    void empty_list_should_have_0_size() {
        // expect
        assertThat(tut.size()).isEqualTo(0);
    }

    @Test
    void should_add_elements() {
        // when
        tut.add(1);
        tut.add(10);
        tut.add(2);

        // then
        assertThat(tut.size()).isEqualTo(3);
    }

    @Test
    void should_read_all_added_elements_in_order_FIFO() {
        // when
        tut.add(7);
        tut.add(3);
        tut.add(10);

        // when
        int[] elements = tut.getAllInOrderFIFO();

        // then
        assertThat(elements).containsExactly(7, 3, 10);
    }

    @Test
    void should_remove_added_elements_in_order_FIFO() {
        // when
        tut.add(1);
        tut.add(10);
        tut.add(2);

        // expect
        assertThat(tut.removeFIFO()).get().isEqualTo(1);
        assertThat(tut.size()).isEqualTo(2);

        assertThat(tut.removeFIFO()).get().isEqualTo(10);
        assertThat(tut.size()).isEqualTo(1);

        assertThat(tut.removeFIFO()).get().isEqualTo(2);
        assertThat(tut.size()).isEqualTo(0);

        assertThat(tut.removeFIFO()).isEmpty();
    }
}