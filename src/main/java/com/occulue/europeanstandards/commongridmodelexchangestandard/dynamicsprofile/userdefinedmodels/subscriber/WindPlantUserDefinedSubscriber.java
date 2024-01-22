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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.subscriber;

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
 * Subscriber for WindPlantUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("windPlantUserDefined-subscriber")
public class WindPlantUserDefinedSubscriber extends BaseSubscriber {

  public WindPlantUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindPlantUserDefined>, WindPlantUserDefined>
      windPlantUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindPlantUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(WindPlantUserDefined.class),
        ResponseTypes.instanceOf(WindPlantUserDefined.class));
  }

  public SubscriptionQueryResult<WindPlantUserDefined, WindPlantUserDefined>
      windPlantUserDefinedSubscribe(@DestinationVariable UUID windPlantUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindWindPlantUserDefinedQuery(
            new LoadWindPlantUserDefinedFilter(windPlantUserDefinedId)),
        ResponseTypes.instanceOf(WindPlantUserDefined.class),
        ResponseTypes.instanceOf(WindPlantUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
