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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.subscriber;

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
 * Subscriber for HydroPowerPlant related events. .
 *
 * @author your_name_here
 */
@Component("hydroPowerPlant-subscriber")
public class HydroPowerPlantSubscriber extends BaseSubscriber {

  public HydroPowerPlantSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<HydroPowerPlant>, HydroPowerPlant>
      hydroPowerPlantSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllHydroPowerPlantQuery(),
        ResponseTypes.multipleInstancesOf(HydroPowerPlant.class),
        ResponseTypes.instanceOf(HydroPowerPlant.class));
  }

  public SubscriptionQueryResult<HydroPowerPlant, HydroPowerPlant> hydroPowerPlantSubscribe(
      @DestinationVariable UUID hydroPowerPlantId) {
    return queryGateway.subscriptionQuery(
        new FindHydroPowerPlantQuery(new LoadHydroPowerPlantFilter(hydroPowerPlantId)),
        ResponseTypes.instanceOf(HydroPowerPlant.class),
        ResponseTypes.instanceOf(HydroPowerPlant.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
