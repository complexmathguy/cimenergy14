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
 * Subscriber for SolarGeneratingUnit related events. .
 *
 * @author your_name_here
 */
@Component("solarGeneratingUnit-subscriber")
public class SolarGeneratingUnitSubscriber extends BaseSubscriber {

  public SolarGeneratingUnitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SolarGeneratingUnit>, SolarGeneratingUnit>
      solarGeneratingUnitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSolarGeneratingUnitQuery(),
        ResponseTypes.multipleInstancesOf(SolarGeneratingUnit.class),
        ResponseTypes.instanceOf(SolarGeneratingUnit.class));
  }

  public SubscriptionQueryResult<SolarGeneratingUnit, SolarGeneratingUnit>
      solarGeneratingUnitSubscribe(@DestinationVariable UUID solarGeneratingUnitId) {
    return queryGateway.subscriptionQuery(
        new FindSolarGeneratingUnitQuery(new LoadSolarGeneratingUnitFilter(solarGeneratingUnitId)),
        ResponseTypes.instanceOf(SolarGeneratingUnit.class),
        ResponseTypes.instanceOf(SolarGeneratingUnit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
