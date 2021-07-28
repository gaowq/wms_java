package generate;

import com.example.wms_java.model.Menu;

public interface MenuDao {
    int insert(Menu record);

    int insertSelective(Menu record);
}
