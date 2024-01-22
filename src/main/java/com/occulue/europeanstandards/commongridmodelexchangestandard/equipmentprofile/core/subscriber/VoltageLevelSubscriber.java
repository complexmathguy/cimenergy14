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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for VoltageLevel related events. .
 *
 * @author your_name_here
 */
@Component("voltageLevel-subscriber")
public class VoltageLevelSubscriber extends BaseSubscriber {

  public VoltageLevelSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VoltageLevel>, VoltageLevel> voltageLevelSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVoltageLevelQuery(),
        ResponseTypes.multipleInstancesOf(VoltageLevel.class),
        ResponseTypes.instanceOf(VoltageLevel.class));
  }

  public SubscriptionQueryResult<VoltageLevel, VoltageLevel> voltageLevelSubscribe(
      @DestinationVariable UUID voltageLevelId) {
    return queryGateway.subscriptionQuery(
        new FindVoltageLevelQuery(new LoadVoltageLevelFilter(voltageLevelId)),
        ResponseTypes.instanceOf(VoltageLevel.class),
        ResponseTypes.instanceOf(VoltageLevel.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
