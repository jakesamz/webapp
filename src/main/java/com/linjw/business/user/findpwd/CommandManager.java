package com.linjw.business.user.findpwd;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class CommandManager {
	
    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        //command.setState(commandState);
        return command.execute();
    }
    /**
     * Loopup的注释中的写明了需要返回的bean名字，如果没有写bean name，那么会根据createCommand的函数返回值类型去查找对应的bean
     * @return
     */
    @Lookup("mailSender")
    protected abstract Command createCommand();
}