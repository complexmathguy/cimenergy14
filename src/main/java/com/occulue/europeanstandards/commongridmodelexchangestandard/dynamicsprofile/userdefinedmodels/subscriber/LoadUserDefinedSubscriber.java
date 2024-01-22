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
 * Subscriber for LoadUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("loadUserDefined-subscriber")
public class LoadUserDefinedSubscriber extends BaseSubscriber {

  public LoadUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LoadUserDefined>, LoadUserDefined>
      loadUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLoadUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(LoadUserDefined.class),
        ResponseTypes.instanceOf(LoadUserDefined.class));
  }

  public SubscriptionQueryResult<LoadUserDefined, LoadUserDefined> loadUserDefinedSubscribe(
      @DestinationVariable UUID loadUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindLoadUserDefinedQuery(new LoadLoadUserDefinedFilter(loadUserDefinedId)),
        ResponseTypes.instanceOf(LoadUserDefined.class),
        ResponseTypes.instanceOf(LoadUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
