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
 * Subscriber for ExcOEX3T related events. .
 *
 * @author your_name_here
 */
@Component("excOEX3T-subscriber")
public class ExcOEX3TSubscriber extends BaseSubscriber {

  public ExcOEX3TSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcOEX3T>, ExcOEX3T> excOEX3TSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcOEX3TQuery(),
        ResponseTypes.multipleInstancesOf(ExcOEX3T.class),
        ResponseTypes.instanceOf(ExcOEX3T.class));
  }

  public SubscriptionQueryResult<ExcOEX3T, ExcOEX3T> excOEX3TSubscribe(
      @DestinationVariable UUID excOEX3TId) {
    return queryGateway.subscriptionQuery(
        new FindExcOEX3TQuery(new LoadExcOEX3TFilter(excOEX3TId)),
        ResponseTypes.instanceOf(ExcOEX3T.class),
        ResponseTypes.instanceOf(ExcOEX3T.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
