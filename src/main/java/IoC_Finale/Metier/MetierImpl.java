package IoC_Finale.Metier;

import IoC_Finale.Dao.IData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier{

    @Autowired
    @Qualifier("dataExt")
    private IData datacall;

    @Override
    public double calcul()
    {
        return datacall.getData()*2;
    }

    public void setDatacall(IData data)
    {
        this.datacall=data;
    }
}
