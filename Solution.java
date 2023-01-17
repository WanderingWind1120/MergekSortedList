package org.example;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int min_index = 0;
        ListNode head = new ListNode(0);// declare object head cụ thể là linked list head có tham số pass in là integer 0
        ListNode h = head; // declare Linked List h có giá trị bằng linked list head
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) { // Nếu Array có k phần tử là những linked list ở vị trí thứ i không Null
                    if (lists[i].val < min) { // Nếu giá trị Int val của linkedlist ở vị trí thứ i này nhỏ hơn min
                        min_index = i; // thì gán giá trị của min_index bằng giá bị của biến loop i hiện tại
                        min = lists[i].val; // và gán giạ trị của min bằng Int val của Linkedlist ở vị trí thứ i
                    }
                    isBreak = false; // Nếu if statement vẫn thỏa mãn thì gán Boolean ngắt isBreak = false
                    // và nó sẽ skip if statement phía sau và tiếp tục chạy forloop
                }

            }
            if (isBreak) {
                break;

            // Bản chất của for loop bên trên là để tìm ra phần tử đầu tiên và nhỏ nhất trong các linked list có trong array
                // các linked list được pass in
            }
            ListNode a = new ListNode(lists[min_index].val); // Declare Linked List a với tham số pass in là giá trị của tham số pass in
                        // là giá trị của phần từ đẩu tiên của linked list tại vị trí mà có phần tử đầu tiên nhỏ nhất trong các Linked
                        // List
            h.next = a; // Gán Linked List next nằm trong declaration của Linked List h với giá trị là Linked List a
            // Nối các list node đã được lọc qua mỗi vòng so sánh và đã được gán giá trị val vào Linked list cần xếp
            h = h.next; // Gán Linked List h với giá trị là Linked list next nằm trong declaration của Linked list h sau khi được
            // gán giá trị là a
            // Gán Linked node h thành chính node tiếp theo cuar nó (h.next) để gán giá trị tiếp theo (h.next.next nếu không declare
            // dòng này / Cái này giả  dụ cho dễ hiểu chứ k declare dòng này thì k xoay loop được) trong vòng loop tiếp theo
            lists[min_index] = lists[min_index].next;  //  Gán Linked List tại vị trí có phần tử đầu tiên nhỏ nhất bằng Linked List
            // next có trong declaration của nó
            // Cái dòng này nó bản chất dùng để giả định và xoay vòng cái for loop tìm phần tử bé nhất bên trên
            // giả định đây chính là đẩy cái phần tử thứ 2 của linked list đã được xác định là chứa phần tử đầu tiên nhỏ nhất trong
            // các phần từ đầu tiên của các linked list
            // lên so sánh tiếp với các phần tử của các linked list còn  hiện đang trong vòng for loop để tìm phần tử nhỏ nhất tiếp
            // theo
        }
        h.next = null; // khi đã hoàn thành sắp xếp phải ngắt Recursive có trong object

        // Cái thằng Linked list h ở đây nó có ý nghĩa giống như 1 biến chạy trong vòng loop vì nó phải thay đổi giá trị liên tục
        // để xoay vòng loop, hay hiểu nôm na là nó đang tạo recursive
        return head.next;
    }
}

// Bản chất Linked list - Stack  cx có thể hiểu là một dạng recursive khi mà đến 1 phần tử trong linked list nó sẽ gọi ra phần tử cùng
// form hay có thể hiểu là cùng class tiếp theo , một dạng của recursive
// Cái Linked List nó được biểu thị thông qua Declaration của từng List Node ở chỗ recursive/declare Node tiếp theo ở đây node tiếp
// theo có tên là next