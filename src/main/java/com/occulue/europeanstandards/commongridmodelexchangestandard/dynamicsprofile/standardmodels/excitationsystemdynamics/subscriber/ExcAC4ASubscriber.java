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
 * Subscriber for ExcAC4A related events. .
 *
 * @author your_name_here
 */
@Component("excAC4A-subscriber")
public class ExcAC4ASubscriber extends BaseSubscriber {

  public ExcAC4ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcAC4A>, ExcAC4A> excAC4ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcAC4AQuery(),
        ResponseTypes.multipleInstancesOf(ExcAC4A.class),
        ResponseTypes.instanceOf(ExcAC4A.class));
  }

  public SubscriptionQueryResult<ExcAC4A, ExcAC4A> excAC4ASubscribe(
      @DestinationVariable UUID excAC4AId) {
    return queryGateway.subscriptionQuery(
        new FindExcAC4AQuery(new LoadExcAC4AFilter(excAC4AId)),
        ResponseTypes.instanceOf(ExcAC4A.class),
        ResponseTypes.instanceOf(ExcAC4A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
