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
 * Projector for WindPlantFreqPcontrolIEC as outlined for the CQRS pattern. All event handling and
 * query handling related to WindPlantFreqPcontrolIEC are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by WindPlantFreqPcontrolIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windPlantFreqPcontrolIEC")
@Component("windPlantFreqPcontrolIEC-projector")
public class WindPlantFreqPcontrolIECProjector extends WindPlantFreqPcontrolIECEntityProjector {

  // core constructor
  public WindPlantFreqPcontrolIECProjector(
      WindPlantFreqPcontrolIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = CreateWindPlantFreqPcontrolIECEvent.class)
  public void handle(CreateWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling CreateWindPlantFreqPcontrolIECEvent - " + event);
    WindPlantFreqPcontrolIEC entity = new WindPlantFreqPcontrolIEC();
    entity.setWindPlantFreqPcontrolIECId(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UpdateWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UpdateWindPlantFreqPcontrolIECEvent.class)
  public void handle(UpdateWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UpdateWindPlantFreqPcontrolIECEvent - " + event);

    WindPlantFreqPcontrolIEC entity = new WindPlantFreqPcontrolIEC();
    entity.setWindPlantFreqPcontrolIECId(event.getWindPlantFreqPcontrolIECId());
    entity.setDprefmax(event.getDprefmax());
    entity.setDprefmin(event.getDprefmin());
    entity.setKiwpp(event.getKiwpp());
    entity.setKpwpp(event.getKpwpp());
    entity.setPrefmax(event.getPrefmax());
    entity.setPrefmin(event.getPrefmin());
    entity.setTpft(event.getTpft());
    entity.setTpfv(event.getTpfv());
    entity.setTwpffilt(event.getTwpffilt());
    entity.setTwppfilt(event.getTwppfilt());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event DeleteWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = DeleteWindPlantFreqPcontrolIECEvent.class)
  public void handle(DeleteWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling DeleteWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = delete(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignDprefmaxToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignDprefmaxToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignDprefmaxToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignDprefmaxToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignDprefmax(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignDprefmax(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignDprefminToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignDprefminToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignDprefminToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignDprefminToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignDprefmin(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignDprefminFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignDprefminFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignDprefminFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignDprefminFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignDprefmin(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignKiwppToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignKiwppToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignKiwppToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignKiwppToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignKiwpp(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignKiwppFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignKiwppFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignKiwppFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignKiwppFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignKiwpp(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignKpwppToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignKpwppToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignKpwppToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignKpwppToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignKpwpp(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignKpwppFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignKpwppFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignKpwppFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignKpwppFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignKpwpp(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignPrefmaxToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignPrefmaxToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignPrefmaxToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignPrefmaxToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignPrefmax(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignPrefmax(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignPrefminToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignPrefminToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignPrefminToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignPrefminToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignPrefmin(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignPrefminFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignPrefminFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignPrefminFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignPrefminFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignPrefmin(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignTpftToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignTpftToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignTpftToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignTpftToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignTpft(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignTpftFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignTpftFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignTpftFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignTpftFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignTpft(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignTpfvToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignTpfvToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignTpfvToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignTpfvToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignTpfv(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignTpfvFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignTpfvFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignTpfvFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignTpfvFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignTpfv(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignTwpffiltToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignTwpffiltToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignTwpffiltToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignTwpffiltToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignTwpffilt(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignTwpffilt(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event AssignTwppfiltToWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = AssignTwppfiltToWindPlantFreqPcontrolIECEvent.class)
  public void handle(AssignTwppfiltToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling AssignTwppfiltToWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity =
        assignTwppfilt(event.getWindPlantFreqPcontrolIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /*
   * @param	event UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent
   */
  @EventHandler(payloadType = UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent.class)
  public void handle(UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("handling UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = unAssignTwppfilt(event.getWindPlantFreqPcontrolIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantFreqPcontrolIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantFreqPcontrolIEC(entity);
  }

  /**
   * Method to retrieve the WindPlantFreqPcontrolIEC via an WindPlantFreqPcontrolIECPrimaryKey.
   *
   * @param id Long
   * @return WindPlantFreqPcontrolIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindPlantFreqPcontrolIEC handle(FindWindPlantFreqPcontrolIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindPlantFreqPcontrolIECId());
  }

  /**
   * Method to retrieve a collection of all WindPlantFreqPcontrolIECs
   *
   * @param query FindAllWindPlantFreqPcontrolIECQuery
   * @return List<WindPlantFreqPcontrolIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindPlantFreqPcontrolIEC> handle(FindAllWindPlantFreqPcontrolIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindPlantFreqPcontrolIEC, but only if the id matches
   *
   * @param entity WindPlantFreqPcontrolIEC
   */
  protected void emitFindWindPlantFreqPcontrolIEC(WindPlantFreqPcontrolIEC entity) {
    LOGGER.info("handling emitFindWindPlantFreqPcontrolIEC");

    queryUpdateEmitter.emit(
        FindWindPlantFreqPcontrolIECQuery.class,
        query ->
            query
                .getFilter()
                .getWindPlantFreqPcontrolIECId()
                .equals(entity.getWindPlantFreqPcontrolIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindPlantFreqPcontrolIEC
   *
   * @param entity WindPlantFreqPcontrolIEC
   */
  protected void emitFindAllWindPlantFreqPcontrolIEC(WindPlantFreqPcontrolIEC entity) {
    LOGGER.info("handling emitFindAllWindPlantFreqPcontrolIEC");

    queryUpdateEmitter.emit(FindAllWindPlantFreqPcontrolIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantFreqPcontrolIECProjector.class.getName());
}
