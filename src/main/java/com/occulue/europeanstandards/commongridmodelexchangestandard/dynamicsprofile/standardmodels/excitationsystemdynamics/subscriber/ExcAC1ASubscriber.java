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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

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
 * Subscriber for ExcAC1A related events. .
 *
 * @author your_name_here
 */
@Component("excAC1A-subscriber")
public class ExcAC1ASubscriber extends BaseSubscriber {

  public ExcAC1ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcAC1A>, ExcAC1A> excAC1ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcAC1AQuery(),
        ResponseTypes.multipleInstancesOf(ExcAC1A.class),
        ResponseTypes.instanceOf(ExcAC1A.class));
  }

  public SubscriptionQueryResult<ExcAC1A, ExcAC1A> excAC1ASubscribe(
      @DestinationVariable UUID excAC1AId) {
    return queryGateway.subscriptionQuery(
        new FindExcAC1AQuery(new LoadExcAC1AFilter(excAC1AId)),
        ResponseTypes.instanceOf(ExcAC1A.class),
        ResponseTypes.instanceOf(ExcAC1A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
