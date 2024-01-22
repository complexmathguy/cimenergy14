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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.subscriber;

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
 * Subscriber for EnergyArea related events. .
 *
 * @author your_name_here
 */
@Component("energyArea-subscriber")
public class EnergyAreaSubscriber extends BaseSubscriber {

  public EnergyAreaSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EnergyArea>, EnergyArea> energyAreaSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEnergyAreaQuery(),
        ResponseTypes.multipleInstancesOf(EnergyArea.class),
        ResponseTypes.instanceOf(EnergyArea.class));
  }

  public SubscriptionQueryResult<EnergyArea, EnergyArea> energyAreaSubscribe(
      @DestinationVariable UUID energyAreaId) {
    return queryGateway.subscriptionQuery(
        new FindEnergyAreaQuery(new LoadEnergyAreaFilter(energyAreaId)),
        ResponseTypes.instanceOf(EnergyArea.class),
        ResponseTypes.instanceOf(EnergyArea.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
