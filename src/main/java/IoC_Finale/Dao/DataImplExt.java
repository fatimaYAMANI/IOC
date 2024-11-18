package IoC_Finale.Dao;

import org.springframework.stereotype.Component;

@Component("dataExt")
public class DataImplExt implements IData{

    private double data=40.0;

    @Override
    public double getData()
    {
        return this.data;
    }
}
