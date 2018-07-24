package agile.config.fastjson;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

/**
 * 数据脱敏过滤器
 *
 */
public class DataMaskingFilter implements PropertyPreFilter {

    private Set<String> excludes = new HashSet<String>();

    public DataMaskingFilter() {
        super();
        excludes.add("password");
        excludes.add("secret");
    }

    public DataMaskingFilter(String... properties) {
        super();
        for (String item : properties) {
            if (item != null) {
                this.excludes.add(item);
            }
        }
    }

    @Override
    public boolean apply(JSONSerializer serializer, Object object, String name) {
        if (null == object || excludes.size() == 0) {
            return true;
        }

        if (excludes.contains(name)) {
            return false;
        }

        return true;
    }

}