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
 * Subscriber for TurbineLoadControllerUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("turbineLoadControllerUserDefined-subscriber")
public class TurbineLoadControllerUserDefinedSubscriber extends BaseSubscriber {

  public TurbineLoadControllerUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<TurbineLoadControllerUserDefined>, TurbineLoadControllerUserDefined>
      turbineLoadControllerUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTurbineLoadControllerUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(TurbineLoadControllerUserDefined.class),
        ResponseTypes.instanceOf(TurbineLoadControllerUserDefined.class));
  }

  public SubscriptionQueryResult<TurbineLoadControllerUserDefined, TurbineLoadControllerUserDefined>
      turbineLoadControllerUserDefinedSubscribe(
          @DestinationVariable UUID turbineLoadControllerUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindTurbineLoadControllerUserDefinedQuery(
            new LoadTurbineLoadControllerUserDefinedFilter(turbineLoadControllerUserDefinedId)),
        ResponseTypes.instanceOf(TurbineLoadControllerUserDefined.class),
        ResponseTypes.instanceOf(TurbineLoadControllerUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
