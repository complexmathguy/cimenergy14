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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for WindTurbineType1or2IEC as outlined for the CQRS pattern. All event handling and
 * query handling related to WindTurbineType1or2IEC are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by WindTurbineType1or2IECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windTurbineType1or2IEC")
@Component("windTurbineType1or2IEC-projector")
public class WindTurbineType1or2IECProjector extends WindTurbineType1or2IECEntityProjector {

  // core constructor
  public WindTurbineType1or2IECProjector(
      WindTurbineType1or2IECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindTurbineType1or2IECEvent
   */
  @EventHandler(payloadType = CreateWindTurbineType1or2IECEvent.class)
  public void handle(CreateWindTurbineType1or2IECEvent event) {
    LOGGER.info("handling CreateWindTurbineType1or2IECEvent - " + event);
    WindTurbineType1or2IEC entity = new WindTurbineType1or2IEC();
    entity.setWindTurbineType1or2IECId(event.getWindTurbineType1or2IECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType1or2IEC(entity);
  }

  /*
   * @param	event UpdateWindTurbineType1or2IECEvent
   */
  @EventHandler(payloadType = UpdateWindTurbineType1or2IECEvent.class)
  public void handle(UpdateWindTurbineType1or2IECEvent event) {
    LOGGER.info("handling UpdateWindTurbineType1or2IECEvent - " + event);

    WindTurbineType1or2IEC entity = new WindTurbineType1or2IEC();
    entity.setWindTurbineType1or2IECId(event.getWindTurbineType1or2IECId());
    entity.setWindTurbineType1or2IEC(event.getWindTurbineType1or2IEC());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindTurbineType1or2IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType1or2IEC(entity);
  }

  /*
   * @param	event DeleteWindTurbineType1or2IECEvent
   */
  @EventHandler(payloadType = DeleteWindTurbineType1or2IECEvent.class)
  public void handle(DeleteWindTurbineType1or2IECEvent event) {
    LOGGER.info("handling DeleteWindTurbineType1or2IECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindTurbineType1or2IEC entity = delete(event.getWindTurbineType1or2IECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType1or2IEC(entity);
  }

  /*
   * @param	event AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent
   */
  @EventHandler(payloadType = AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent.class)
  public void handle(AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent event) {
    LOGGER.info("handling AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindTurbineType1or2IEC entity =
        assignWindTurbineType1or2IEC(event.getWindTurbineType1or2IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindTurbineType1or2IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType1or2IEC(entity);
  }

  /*
   * @param	event UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent
   */
  @EventHandler(payloadType = UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent.class)
  public void handle(UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent event) {
    LOGGER.info(
        "handling UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindTurbineType1or2IEC entity =
        unAssignWindTurbineType1or2IEC(event.getWindTurbineType1or2IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindTurbineType1or2IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType1or2IEC(entity);
  }

  /**
   * Method to retrieve the WindTurbineType1or2IEC via an WindTurbineType1or2IECPrimaryKey.
   *
   * @param id Long
   * @return WindTurbineType1or2IEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindTurbineType1or2IEC handle(FindWindTurbineType1or2IECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindTurbineType1or2IECId());
  }

  /**
   * Method to retrieve a collection of all WindTurbineType1or2IECs
   *
   * @param query FindAllWindTurbineType1or2IECQuery
   * @return List<WindTurbineType1or2IEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindTurbineType1or2IEC> handle(FindAllWindTurbineType1or2IECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindTurbineType1or2IEC, but only if the id matches
   *
   * @param entity WindTurbineType1or2IEC
   */
  protected void emitFindWindTurbineType1or2IEC(WindTurbineType1or2IEC entity) {
    LOGGER.info("handling emitFindWindTurbineType1or2IEC");

    queryUpdateEmitter.emit(
        FindWindTurbineType1or2IECQuery.class,
        query ->
            query
                .getFilter()
                .getWindTurbineType1or2IECId()
                .equals(entity.getWindTurbineType1or2IECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindTurbineType1or2IEC
   *
   * @param entity WindTurbineType1or2IEC
   */
  protected void emitFindAllWindTurbineType1or2IEC(WindTurbineType1or2IEC entity) {
    LOGGER.info("handling emitFindAllWindTurbineType1or2IEC");

    queryUpdateEmitter.emit(FindAllWindTurbineType1or2IECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType1or2IECProjector.class.getName());
}
