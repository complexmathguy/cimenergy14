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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for CapacitancePerLength related events. .
 *
 * @author your_name_here
 */
@Component("capacitancePerLength-subscriber")
public class CapacitancePerLengthSubscriber extends BaseSubscriber {

  public CapacitancePerLengthSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<CapacitancePerLength>, CapacitancePerLength>
      capacitancePerLengthSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllCapacitancePerLengthQuery(),
        ResponseTypes.multipleInstancesOf(CapacitancePerLength.class),
        ResponseTypes.instanceOf(CapacitancePerLength.class));
  }

  public SubscriptionQueryResult<CapacitancePerLength, CapacitancePerLength>
      capacitancePerLengthSubscribe(@DestinationVariable UUID capacitancePerLengthId) {
    return queryGateway.subscriptionQuery(
        new FindCapacitancePerLengthQuery(
            new LoadCapacitancePerLengthFilter(capacitancePerLengthId)),
        ResponseTypes.instanceOf(CapacitancePerLength.class),
        ResponseTypes.instanceOf(CapacitancePerLength.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
