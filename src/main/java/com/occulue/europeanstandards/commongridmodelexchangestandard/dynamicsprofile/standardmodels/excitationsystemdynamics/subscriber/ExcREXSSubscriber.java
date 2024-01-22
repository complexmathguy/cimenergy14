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
 * Subscriber for ExcREXS related events. .
 *
 * @author your_name_here
 */
@Component("excREXS-subscriber")
public class ExcREXSSubscriber extends BaseSubscriber {

  public ExcREXSSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcREXS>, ExcREXS> excREXSSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcREXSQuery(),
        ResponseTypes.multipleInstancesOf(ExcREXS.class),
        ResponseTypes.instanceOf(ExcREXS.class));
  }

  public SubscriptionQueryResult<ExcREXS, ExcREXS> excREXSSubscribe(
      @DestinationVariable UUID excREXSId) {
    return queryGateway.subscriptionQuery(
        new FindExcREXSQuery(new LoadExcREXSFilter(excREXSId)),
        ResponseTypes.instanceOf(ExcREXS.class),
        ResponseTypes.instanceOf(ExcREXS.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
