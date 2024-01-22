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
 * Subscriber for ExcAVR1 related events. .
 *
 * @author your_name_here
 */
@Component("excAVR1-subscriber")
public class ExcAVR1Subscriber extends BaseSubscriber {

  public ExcAVR1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcAVR1>, ExcAVR1> excAVR1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcAVR1Query(),
        ResponseTypes.multipleInstancesOf(ExcAVR1.class),
        ResponseTypes.instanceOf(ExcAVR1.class));
  }

  public SubscriptionQueryResult<ExcAVR1, ExcAVR1> excAVR1Subscribe(
      @DestinationVariable UUID excAVR1Id) {
    return queryGateway.subscriptionQuery(
        new FindExcAVR1Query(new LoadExcAVR1Filter(excAVR1Id)),
        ResponseTypes.instanceOf(ExcAVR1.class),
        ResponseTypes.instanceOf(ExcAVR1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
