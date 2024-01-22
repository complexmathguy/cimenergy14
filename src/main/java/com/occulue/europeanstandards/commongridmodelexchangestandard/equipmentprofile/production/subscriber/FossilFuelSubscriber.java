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
 * Subscriber for FossilFuel related events. .
 *
 * @author your_name_here
 */
@Component("fossilFuel-subscriber")
public class FossilFuelSubscriber extends BaseSubscriber {

  public FossilFuelSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<FossilFuel>, FossilFuel> fossilFuelSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllFossilFuelQuery(),
        ResponseTypes.multipleInstancesOf(FossilFuel.class),
        ResponseTypes.instanceOf(FossilFuel.class));
  }

  public SubscriptionQueryResult<FossilFuel, FossilFuel> fossilFuelSubscribe(
      @DestinationVariable UUID fossilFuelId) {
    return queryGateway.subscriptionQuery(
        new FindFossilFuelQuery(new LoadFossilFuelFilter(fossilFuelId)),
        ResponseTypes.instanceOf(FossilFuel.class),
        ResponseTypes.instanceOf(FossilFuel.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
