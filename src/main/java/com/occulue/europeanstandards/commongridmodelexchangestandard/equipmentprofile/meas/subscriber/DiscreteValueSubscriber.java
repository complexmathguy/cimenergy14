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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

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
 * Subscriber for DiscreteValue related events. .
 *
 * @author your_name_here
 */
@Component("discreteValue-subscriber")
public class DiscreteValueSubscriber extends BaseSubscriber {

  public DiscreteValueSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DiscreteValue>, DiscreteValue> discreteValueSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiscreteValueQuery(),
        ResponseTypes.multipleInstancesOf(DiscreteValue.class),
        ResponseTypes.instanceOf(DiscreteValue.class));
  }

  public SubscriptionQueryResult<DiscreteValue, DiscreteValue> discreteValueSubscribe(
      @DestinationVariable UUID discreteValueId) {
    return queryGateway.subscriptionQuery(
        new FindDiscreteValueQuery(new LoadDiscreteValueFilter(discreteValueId)),
        ResponseTypes.instanceOf(DiscreteValue.class),
        ResponseTypes.instanceOf(DiscreteValue.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
