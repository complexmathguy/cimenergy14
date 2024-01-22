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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.subscriber;

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
 * Subscriber for EnergySource related events. .
 *
 * @author your_name_here
 */
@Component("energySource-subscriber")
public class EnergySourceSubscriber extends BaseSubscriber {

  public EnergySourceSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EnergySource>, EnergySource> energySourceSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEnergySourceQuery(),
        ResponseTypes.multipleInstancesOf(EnergySource.class),
        ResponseTypes.instanceOf(EnergySource.class));
  }

  public SubscriptionQueryResult<EnergySource, EnergySource> energySourceSubscribe(
      @DestinationVariable UUID energySourceId) {
    return queryGateway.subscriptionQuery(
        new FindEnergySourceQuery(new LoadEnergySourceFilter(energySourceId)),
        ResponseTypes.instanceOf(EnergySource.class),
        ResponseTypes.instanceOf(EnergySource.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
