package ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.plugin.com.BeanClass;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleIoc {

    //创建bean容器
    private Map<String, Object> beanMap = new HashMap<>();

    //通过构造方法加载xml文件，解析注入
    public SimpleIoc(String loadPath) throws Exception {
        loadBeans(loadPath);
    }

    //解析xml文件,Dom树形解析
    private void loadBeans(String loadPath) throws Exception {
        //加载配置文件
        InputStream inputStream = new FileInputStream(loadPath);
        //通过静态工厂获取dom工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //获取dom解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析dom文件
        Document document = builder.parse(inputStream);
        //获取到根标签beans
        Element root = document.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        //遍历bean标签
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");

                //加载beanClass
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                //创建bean对象
                Object bean = beanClass.newInstance();

                //遍历property标签
                NodeList property = ele.getElementsByTagName("property");
                for (int j = 0; j < property.getLength(); j++) {
                    Node pNode = property.item(j);
                    if (pNode instanceof Element) {
                        Element pEle = (Element) pNode;
                        String name = pEle.getAttribute("name");
                        String value = pEle.getAttribute("value");

                        //使用反射将bean的相关属性设置为可访问
                        Field field = bean.getClass().getDeclaredField(name);
                        field.setAccessible(true);
                        if (value != null && value.length() > 0) {
                            //将普通属性值写入bean对象中
                            field.set(bean, value);
                        }else{
                            //将引用属性写入bean对象中
                            String ref = pEle.getAttribute("ref");
                            if(ref !=null && ref.length()>0){
                                field.set(bean,getBean(ref));
                            }
                        }
                    }
                }
                //将bean放入到bean容器中
                beanMap.put(id,bean);
            }
        }
    }
//根据bean的id获取bean对象
    public Object getBean(String name){
        Object bean = beanMap.get(name);
        if(bean !=null){
            return bean;
        }else{
            throw new IllegalArgumentException("There id no "+name+" bean!");
        }
    }
}
