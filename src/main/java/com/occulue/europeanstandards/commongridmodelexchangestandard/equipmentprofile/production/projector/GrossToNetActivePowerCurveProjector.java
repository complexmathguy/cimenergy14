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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GrossToNetActivePowerCurve as outlined for the CQRS pattern. All event handling and
 * query handling related to GrossToNetActivePowerCurve are invoked here and dispersed as an event
 * to be handled elsewhere.
 *
 * <p>Commands are handled by GrossToNetActivePowerCurveAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("grossToNetActivePowerCurve")
@Component("grossToNetActivePowerCurve-projector")
public class GrossToNetActivePowerCurveProjector extends GrossToNetActivePowerCurveEntityProjector {

  // core constructor
  public GrossToNetActivePowerCurveProjector(
      GrossToNetActivePowerCurveRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGrossToNetActivePowerCurveEvent
   */
  @EventHandler(payloadType = CreateGrossToNetActivePowerCurveEvent.class)
  public void handle(CreateGrossToNetActivePowerCurveEvent event) {
    LOGGER.info("handling CreateGrossToNetActivePowerCurveEvent - " + event);
    GrossToNetActivePowerCurve entity = new GrossToNetActivePowerCurve();
    entity.setGrossToNetActivePowerCurveId(event.getGrossToNetActivePowerCurveId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGrossToNetActivePowerCurve(entity);
  }

  /*
   * @param	event UpdateGrossToNetActivePowerCurveEvent
   */
  @EventHandler(payloadType = UpdateGrossToNetActivePowerCurveEvent.class)
  public void handle(UpdateGrossToNetActivePowerCurveEvent event) {
    LOGGER.info("handling UpdateGrossToNetActivePowerCurveEvent - " + event);

    GrossToNetActivePowerCurve entity = new GrossToNetActivePowerCurve();
    entity.setGrossToNetActivePowerCurveId(event.getGrossToNetActivePowerCurveId());
    entity.setGrossToNetActivePowerCurves(event.getGrossToNetActivePowerCurves());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGrossToNetActivePowerCurve(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGrossToNetActivePowerCurve(entity);
  }

  /*
   * @param	event DeleteGrossToNetActivePowerCurveEvent
   */
  @EventHandler(payloadType = DeleteGrossToNetActivePowerCurveEvent.class)
  public void handle(DeleteGrossToNetActivePowerCurveEvent event) {
    LOGGER.info("handling DeleteGrossToNetActivePowerCurveEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GrossToNetActivePowerCurve entity = delete(event.getGrossToNetActivePowerCurveId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGrossToNetActivePowerCurve(entity);
  }

  /*
   * @param	event AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent
   */
  @EventHandler(
      payloadType = AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent.class)
  public void handle(AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent event) {
    LOGGER.info(
        "handling AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    GrossToNetActivePowerCurve entity =
        addToGrossToNetActivePowerCurves(event.getGrossToNetActivePowerCurveId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGrossToNetActivePowerCurve(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGrossToNetActivePowerCurve(entity);
  }

  /*
   * @param	event RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent
   */
  @EventHandler(
      payloadType = RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent.class)
  public void handle(RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent event) {
    LOGGER.info(
        "handling RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent - " + event);

    GrossToNetActivePowerCurve entity =
        removeFromGrossToNetActivePowerCurves(
            event.getGrossToNetActivePowerCurveId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGrossToNetActivePowerCurve(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGrossToNetActivePowerCurve(entity);
  }

  /**
   * Method to retrieve the GrossToNetActivePowerCurve via an GrossToNetActivePowerCurvePrimaryKey.
   *
   * @param id Long
   * @return GrossToNetActivePowerCurve
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GrossToNetActivePowerCurve handle(FindGrossToNetActivePowerCurveQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGrossToNetActivePowerCurveId());
  }

  /**
   * Method to retrieve a collection of all GrossToNetActivePowerCurves
   *
   * @param query FindAllGrossToNetActivePowerCurveQuery
   * @return List<GrossToNetActivePowerCurve>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GrossToNetActivePowerCurve> handle(FindAllGrossToNetActivePowerCurveQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGrossToNetActivePowerCurve, but only if the id matches
   *
   * @param entity GrossToNetActivePowerCurve
   */
  protected void emitFindGrossToNetActivePowerCurve(GrossToNetActivePowerCurve entity) {
    LOGGER.info("handling emitFindGrossToNetActivePowerCurve");

    queryUpdateEmitter.emit(
        FindGrossToNetActivePowerCurveQuery.class,
        query ->
            query
                .getFilter()
                .getGrossToNetActivePowerCurveId()
                .equals(entity.getGrossToNetActivePowerCurveId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGrossToNetActivePowerCurve
   *
   * @param entity GrossToNetActivePowerCurve
   */
  protected void emitFindAllGrossToNetActivePowerCurve(GrossToNetActivePowerCurve entity) {
    LOGGER.info("handling emitFindAllGrossToNetActivePowerCurve");

    queryUpdateEmitter.emit(FindAllGrossToNetActivePowerCurveQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(GrossToNetActivePowerCurveProjector.class.getName());
}
