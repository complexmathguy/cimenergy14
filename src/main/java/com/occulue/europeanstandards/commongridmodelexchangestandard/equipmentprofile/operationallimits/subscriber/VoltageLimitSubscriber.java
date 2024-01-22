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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.subscriber;

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
 * Subscriber for VoltageLimit related events. .
 *
 * @author your_name_here
 */
@Component("voltageLimit-subscriber")
public class VoltageLimitSubscriber extends BaseSubscriber {

  public VoltageLimitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VoltageLimit>, VoltageLimit> voltageLimitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVoltageLimitQuery(),
        ResponseTypes.multipleInstancesOf(VoltageLimit.class),
        ResponseTypes.instanceOf(VoltageLimit.class));
  }

  public SubscriptionQueryResult<VoltageLimit, VoltageLimit> voltageLimitSubscribe(
      @DestinationVariable UUID voltageLimitId) {
    return queryGateway.subscriptionQuery(
        new FindVoltageLimitQuery(new LoadVoltageLimitFilter(voltageLimitId)),
        ResponseTypes.instanceOf(VoltageLimit.class),
        ResponseTypes.instanceOf(VoltageLimit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
