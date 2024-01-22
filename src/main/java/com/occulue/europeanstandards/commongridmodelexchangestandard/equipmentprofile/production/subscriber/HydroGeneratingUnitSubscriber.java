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
 * Subscriber for HydroGeneratingUnit related events. .
 *
 * @author your_name_here
 */
@Component("hydroGeneratingUnit-subscriber")
public class HydroGeneratingUnitSubscriber extends BaseSubscriber {

  public HydroGeneratingUnitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<HydroGeneratingUnit>, HydroGeneratingUnit>
      hydroGeneratingUnitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllHydroGeneratingUnitQuery(),
        ResponseTypes.multipleInstancesOf(HydroGeneratingUnit.class),
        ResponseTypes.instanceOf(HydroGeneratingUnit.class));
  }

  public SubscriptionQueryResult<HydroGeneratingUnit, HydroGeneratingUnit>
      hydroGeneratingUnitSubscribe(@DestinationVariable UUID hydroGeneratingUnitId) {
    return queryGateway.subscriptionQuery(
        new FindHydroGeneratingUnitQuery(new LoadHydroGeneratingUnitFilter(hydroGeneratingUnitId)),
        ResponseTypes.instanceOf(HydroGeneratingUnit.class),
        ResponseTypes.instanceOf(HydroGeneratingUnit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
