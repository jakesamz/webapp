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
     * Loopup��ע���е�д������Ҫ���ص�bean���֣����û��дbean name����ô�����createCommand�ĺ�������ֵ����ȥ���Ҷ�Ӧ��bean
     * @return
     */
    @Lookup("mailSender")
    protected abstract Command createCommand();
}