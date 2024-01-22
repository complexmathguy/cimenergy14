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
 * Subscriber for WindGeneratingUnit related events. .
 *
 * @author your_name_here
 */
@Component("windGeneratingUnit-subscriber")
public class WindGeneratingUnitSubscriber extends BaseSubscriber {

  public WindGeneratingUnitSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindGeneratingUnit>, WindGeneratingUnit>
      windGeneratingUnitSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindGeneratingUnitQuery(),
        ResponseTypes.multipleInstancesOf(WindGeneratingUnit.class),
        ResponseTypes.instanceOf(WindGeneratingUnit.class));
  }

  public SubscriptionQueryResult<WindGeneratingUnit, WindGeneratingUnit>
      windGeneratingUnitSubscribe(@DestinationVariable UUID windGeneratingUnitId) {
    return queryGateway.subscriptionQuery(
        new FindWindGeneratingUnitQuery(new LoadWindGeneratingUnitFilter(windGeneratingUnitId)),
        ResponseTypes.instanceOf(WindGeneratingUnit.class),
        ResponseTypes.instanceOf(WindGeneratingUnit.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
