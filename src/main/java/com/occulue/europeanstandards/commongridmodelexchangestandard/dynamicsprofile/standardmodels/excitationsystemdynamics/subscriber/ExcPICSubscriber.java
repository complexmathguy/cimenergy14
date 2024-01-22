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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for ExcPIC related events. .
 *
 * @author your_name_here
 */
@Component("excPIC-subscriber")
public class ExcPICSubscriber extends BaseSubscriber {

  public ExcPICSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcPIC>, ExcPIC> excPICSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcPICQuery(),
        ResponseTypes.multipleInstancesOf(ExcPIC.class),
        ResponseTypes.instanceOf(ExcPIC.class));
  }

  public SubscriptionQueryResult<ExcPIC, ExcPIC> excPICSubscribe(
      @DestinationVariable UUID excPICId) {
    return queryGateway.subscriptionQuery(
        new FindExcPICQuery(new LoadExcPICFilter(excPICId)),
        ResponseTypes.instanceOf(ExcPIC.class),
        ResponseTypes.instanceOf(ExcPIC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
