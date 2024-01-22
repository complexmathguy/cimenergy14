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
 * Subscriber for NuclearGeneratingUnit related events. .
 *
 * @author your_name_here
 */
@Component("nuclearGeneratingUnit-subscriber")
public class NuclearGeneratingUnitSubscriber extends BaseSubscriber {

  public NuclearGeneratingUnitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<NuclearGeneratingUnit>, NuclearGeneratingUnit>
      nuclearGeneratingUnitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllNuclearGeneratingUnitQuery(),
        ResponseTypes.multipleInstancesOf(NuclearGeneratingUnit.class),
        ResponseTypes.instanceOf(NuclearGeneratingUnit.class));
  }

  public SubscriptionQueryResult<NuclearGeneratingUnit, NuclearGeneratingUnit>
      nuclearGeneratingUnitSubscribe(@DestinationVariable UUID nuclearGeneratingUnitId) {
    return queryGateway.subscriptionQuery(
        new FindNuclearGeneratingUnitQuery(
            new LoadNuclearGeneratingUnitFilter(nuclearGeneratingUnitId)),
        ResponseTypes.instanceOf(NuclearGeneratingUnit.class),
        ResponseTypes.instanceOf(NuclearGeneratingUnit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
