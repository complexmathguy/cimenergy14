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
 * Subscriber for GeneratingUnit related events. .
 *
 * @author your_name_here
 */
@Component("generatingUnit-subscriber")
public class GeneratingUnitSubscriber extends BaseSubscriber {

  public GeneratingUnitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GeneratingUnit>, GeneratingUnit> generatingUnitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGeneratingUnitQuery(),
        ResponseTypes.multipleInstancesOf(GeneratingUnit.class),
        ResponseTypes.instanceOf(GeneratingUnit.class));
  }

  public SubscriptionQueryResult<GeneratingUnit, GeneratingUnit> generatingUnitSubscribe(
      @DestinationVariable UUID generatingUnitId) {
    return queryGateway.subscriptionQuery(
        new FindGeneratingUnitQuery(new LoadGeneratingUnitFilter(generatingUnitId)),
        ResponseTypes.instanceOf(GeneratingUnit.class),
        ResponseTypes.instanceOf(GeneratingUnit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
