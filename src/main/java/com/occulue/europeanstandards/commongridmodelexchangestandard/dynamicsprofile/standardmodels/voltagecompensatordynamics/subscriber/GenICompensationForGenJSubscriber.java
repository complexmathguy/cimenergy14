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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.subscriber;

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
 * Subscriber for GenICompensationForGenJ related events. .
 *
 * @author your_name_here
 */
@Component("genICompensationForGenJ-subscriber")
public class GenICompensationForGenJSubscriber extends BaseSubscriber {

  public GenICompensationForGenJSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GenICompensationForGenJ>, GenICompensationForGenJ>
      genICompensationForGenJSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGenICompensationForGenJQuery(),
        ResponseTypes.multipleInstancesOf(GenICompensationForGenJ.class),
        ResponseTypes.instanceOf(GenICompensationForGenJ.class));
  }

  public SubscriptionQueryResult<GenICompensationForGenJ, GenICompensationForGenJ>
      genICompensationForGenJSubscribe(@DestinationVariable UUID genICompensationForGenJId) {
    return queryGateway.subscriptionQuery(
        new FindGenICompensationForGenJQuery(
            new LoadGenICompensationForGenJFilter(genICompensationForGenJId)),
        ResponseTypes.instanceOf(GenICompensationForGenJ.class),
        ResponseTypes.instanceOf(GenICompensationForGenJ.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
