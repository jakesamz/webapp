package basic.collections.list;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.beanutils.BeanPropertyValueChangeClosure;
import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ClosureTransformer;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.NullPredicate;
import org.apache.commons.collections.functors.StringValueTransformer;
import org.apache.commons.collections.list.PredicatedList;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;

import basic.bean.User;
import basic.bean.UserList;

public class ListUtils extends org.apache.commons.collections.ListUtils {
	
	public static <T> List<T> removeDuplicatedElementsInOrder(List<T> list){
		if(list == null || list.isEmpty()) {
			return Collections.emptyList();
		}
		List<T> newList = new ArrayList<T>();
		for (T e : list) {
			if(!newList.contains(e)) {
				newList.add(e);
			}
		}
		return newList;
	}
	
	/**
	 * Should be replaced by using CollectionUtils.find(collection, BeanPropertyValueEqualsPredicate)
	 * @param list
	 * @param propertyName
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public static <T> T findElementByPropertyValue(List<T> list, String propertyName, Object value) throws Exception {
		if(list == null || list.isEmpty()) {
			return null;
		}
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, list.get(0).getClass());
		for (T t : list) {
			Object obj = pd.getReadMethod().invoke(t);
			if(StringUtils.equals(String.valueOf(value), String.valueOf(obj))) {
				return t;
			}
		}
		return null;
	}
	
	public static void test() {
		List list = PredicatedList.decorate(
				new ArrayList<String>(Arrays.asList(new String[] {"1a","2b"})), 
				new EqualPredicate("123"));
		
	}
	
	public static void main(String[] args) {
		User user = (User) CollectionUtils.find(UserList.get(), new BeanPropertyValueEqualsPredicate("id", "9587"));
		System.out.println(user);
		CollectionUtils.find(UserList.get(), new BeanPredicate("id", NullPredicate.getInstance()));
		CollectionUtils.collect(UserList.get(), new Transformer() {
			
			@Override
			public Object transform(Object input) {
				// TODO Auto-generated method stub
				return Integer.valueOf(((User)input).getId().toString());
			}
		});
		List list = UserList.get();
		//CollectionUtils.forAllDo(list, new BeanPropertyValueChangeClosure("id", "t"));
		BeanPropertyValueChangeClosure closure = new BeanPropertyValueChangeClosure("id", "t");
		ClosureTransformer transformer = new ClosureTransformer(closure);
		Collection list2 = CollectionUtils.collect(list, transformer);
		System.out.println(list2);
		//CollectionUtils.filter(list, new BeanPredicate("", null));
		
		Object[][] str  = {{"a","b"},{"c","d"}};
		
		Object[][] headers =
			{
				{"Builing Id",1000},
				{"Builing Name",1000},
				{"District",1000},
				{"Address",1000},
				{"Area",1000},
				{"RAM",1000},
				{"PTS",1000},
				{"PCS",1000},
				{"CRM",1000},
				{"PTC",1000}
			};
		System.out.println(headers.length);
		/*for (int i=0; i<headers.length; i++)
		{
			System.out.println(headers[i][1]);
		}*/
		
		List<User> userlist = UserList.get();
		Map<String, List<User>> groupUserMapOne = userlist.stream().collect(Collectors.groupingBy(User::getId));
		
		System.out.println(groupUserMapOne);
		
	}

}
