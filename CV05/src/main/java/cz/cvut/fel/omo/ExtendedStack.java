package cz.cvut.fel.omo;

public interface ExtendedStack {

    /*
     *  Method for inserting new element on top of the stack.
     *  @param int Value to insert
     */
    public void push(int toInsert);

    /*
     *  Method for inserting multiple elements on top of the stack. Elements are inserted in order from first element.
     *  @param int[] Array of values to insert.
     */
    public void push(int[] toInsert);

    /*
     *  Method retrieves value from the top of the stack, value is not removed from the stack.
     *  @return int Value of the item on top of the stack.
     */
    public int top();

    /*
     *  Method for removing element from top of the stack
     *  @return int Element from top of the stack.
     */
    public int pop();

    /*
     *   Method for removing first negative element from the stack.
     *   @return int Top-most negative element in stack.
     */
    public int popFirstNegativeElement();


    /*
     *  Method for determining, whether stack is empty.
     *  @return boolean Empty stack indicator.
     */
    public boolean isEmpty();

    /*
         *  Method for retrieving depth of stack.
         *  @return int Current amount of elements in stack.
         */
    public int getSize();
}
