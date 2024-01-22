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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.subscriber;

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
 * Subscriber for LoadGenericNonLinear related events. .
 *
 * @author your_name_here
 */
@Component("loadGenericNonLinear-subscriber")
public class LoadGenericNonLinearSubscriber extends BaseSubscriber {

  public LoadGenericNonLinearSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LoadGenericNonLinear>, LoadGenericNonLinear>
      loadGenericNonLinearSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLoadGenericNonLinearQuery(),
        ResponseTypes.multipleInstancesOf(LoadGenericNonLinear.class),
        ResponseTypes.instanceOf(LoadGenericNonLinear.class));
  }

  public SubscriptionQueryResult<LoadGenericNonLinear, LoadGenericNonLinear>
      loadGenericNonLinearSubscribe(@DestinationVariable UUID loadGenericNonLinearId) {
    return queryGateway.subscriptionQuery(
        new FindLoadGenericNonLinearQuery(
            new LoadLoadGenericNonLinearFilter(loadGenericNonLinearId)),
        ResponseTypes.instanceOf(LoadGenericNonLinear.class),
        ResponseTypes.instanceOf(LoadGenericNonLinear.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
