package lvl25.lesson05;



public class LoggingStateThread extends Thread
{
    private Thread target;
    public LoggingStateThread(Thread target)
    {
        this.target = target;
        setDaemon(true);

    }

    @Override
    public void run()
    {
        State state = this.target.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.target.getState())
            {
                state = this.target.getState();
                System.out.println(state);
            }
        }
    }
}