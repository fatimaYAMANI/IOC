package IoC_Finale.Dao;

import org.springframework.stereotype.Component;

@Component("data")
public class DataImpl implements IData{

    private double data= 30.0;

    @Override
    public double getData()
    {
        return this.data;
    }
}
