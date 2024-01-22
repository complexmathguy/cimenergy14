/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.delegate;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Base class for application business delegates.
 *
 * <p>
 *
 * @author your_name_here
 */
@Component
public class BaseBusinessDelegate implements ApplicationContextAware {

  public BaseBusinessDelegate() {}

  @Override
  public void setApplicationContext(ApplicationContext ctx) throws BeansException {
    applicationContext = ctx;
  }

  // ************************************************************************
  // Protected / Private Methods
  // ************************************************************************
  protected static ApplicationContext applicationContext;
}
