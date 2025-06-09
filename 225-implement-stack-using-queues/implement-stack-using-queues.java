class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2; 
    int top;
    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
        top = 0;
    }
    
    public void push(int x) {
        top = x;
        que1.offer(x);
    }
    
    public int pop() {
        int ele = 0;
        while(que1.size() > 1)
        {
            top = que1.peek(); 
             ele = que1.remove();
             que2.offer(ele);
        }
       
        while(que2.size() > 0)
        {
             que1.offer(que2.remove());
        }
        return que1.remove();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        if(que1.size() == 0)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */