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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for PhaseTapChangerTablePoint related events. .
 *
 * @author your_name_here
 */
@Component("phaseTapChangerTablePoint-subscriber")
public class PhaseTapChangerTablePointSubscriber extends BaseSubscriber {

  public PhaseTapChangerTablePointSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PhaseTapChangerTablePoint>, PhaseTapChangerTablePoint>
      phaseTapChangerTablePointSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPhaseTapChangerTablePointQuery(),
        ResponseTypes.multipleInstancesOf(PhaseTapChangerTablePoint.class),
        ResponseTypes.instanceOf(PhaseTapChangerTablePoint.class));
  }

  public SubscriptionQueryResult<PhaseTapChangerTablePoint, PhaseTapChangerTablePoint>
      phaseTapChangerTablePointSubscribe(@DestinationVariable UUID phaseTapChangerTablePointId) {
    return queryGateway.subscriptionQuery(
        new FindPhaseTapChangerTablePointQuery(
            new LoadPhaseTapChangerTablePointFilter(phaseTapChangerTablePointId)),
        ResponseTypes.instanceOf(PhaseTapChangerTablePoint.class),
        ResponseTypes.instanceOf(PhaseTapChangerTablePoint.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
