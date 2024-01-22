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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for ReactiveCapabilityCurve related events. .
 *
 * @author your_name_here
 */
@Component("reactiveCapabilityCurve-subscriber")
public class ReactiveCapabilityCurveSubscriber extends BaseSubscriber {

  public ReactiveCapabilityCurveSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ReactiveCapabilityCurve>, ReactiveCapabilityCurve>
      reactiveCapabilityCurveSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllReactiveCapabilityCurveQuery(),
        ResponseTypes.multipleInstancesOf(ReactiveCapabilityCurve.class),
        ResponseTypes.instanceOf(ReactiveCapabilityCurve.class));
  }

  public SubscriptionQueryResult<ReactiveCapabilityCurve, ReactiveCapabilityCurve>
      reactiveCapabilityCurveSubscribe(@DestinationVariable UUID reactiveCapabilityCurveId) {
    return queryGateway.subscriptionQuery(
        new FindReactiveCapabilityCurveQuery(
            new LoadReactiveCapabilityCurveFilter(reactiveCapabilityCurveId)),
        ResponseTypes.instanceOf(ReactiveCapabilityCurve.class),
        ResponseTypes.instanceOf(ReactiveCapabilityCurve.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
