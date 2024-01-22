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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssPTIST3 as outlined for the CQRS pattern. All event handling and query handling
 * related to PssPTIST3 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssPTIST3Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssPTIST3")
@Component("pssPTIST3-projector")
public class PssPTIST3Projector extends PssPTIST3EntityProjector {

  // core constructor
  public PssPTIST3Projector(PssPTIST3Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssPTIST3Event
   */
  @EventHandler(payloadType = CreatePssPTIST3Event.class)
  public void handle(CreatePssPTIST3Event event) {
    LOGGER.info("handling CreatePssPTIST3Event - " + event);
    PssPTIST3 entity = new PssPTIST3();
    entity.setPssPTIST3Id(event.getPssPTIST3Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UpdatePssPTIST3Event
   */
  @EventHandler(payloadType = UpdatePssPTIST3Event.class)
  public void handle(UpdatePssPTIST3Event event) {
    LOGGER.info("handling UpdatePssPTIST3Event - " + event);

    PssPTIST3 entity = new PssPTIST3();
    entity.setPssPTIST3Id(event.getPssPTIST3Id());
    entity.setA0(event.getA0());
    entity.setA1(event.getA1());
    entity.setA2(event.getA2());
    entity.setA3(event.getA3());
    entity.setA4(event.getA4());
    entity.setA5(event.getA5());
    entity.setAl(event.getAl());
    entity.setAthres(event.getAthres());
    entity.setB0(event.getB0());
    entity.setB1(event.getB1());
    entity.setB2(event.getB2());
    entity.setB3(event.getB3());
    entity.setB4(event.getB4());
    entity.setB5(event.getB5());
    entity.setDl(event.getDl());
    entity.setDtc(event.getDtc());
    entity.setDtf(event.getDtf());
    entity.setDtp(event.getDtp());
    entity.setIsw(event.getIsw());
    entity.setK(event.getK());
    entity.setLthres(event.getLthres());
    entity.setM(event.getM());
    entity.setNav(event.getNav());
    entity.setNcl(event.getNcl());
    entity.setNcr(event.getNcr());
    entity.setPmin(event.getPmin());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setTf(event.getTf());
    entity.setTp(event.getTp());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event DeletePssPTIST3Event
   */
  @EventHandler(payloadType = DeletePssPTIST3Event.class)
  public void handle(DeletePssPTIST3Event event) {
    LOGGER.info("handling DeletePssPTIST3Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssPTIST3 entity = delete(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignA0ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignA0ToPssPTIST3Event.class)
  public void handle(AssignA0ToPssPTIST3Event event) {
    LOGGER.info("handling AssignA0ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignA0(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignA0FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignA0FromPssPTIST3Event.class)
  public void handle(UnAssignA0FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignA0FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignA0(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignA1ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignA1ToPssPTIST3Event.class)
  public void handle(AssignA1ToPssPTIST3Event event) {
    LOGGER.info("handling AssignA1ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignA1(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignA1FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignA1FromPssPTIST3Event.class)
  public void handle(UnAssignA1FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignA1FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignA1(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignA2ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignA2ToPssPTIST3Event.class)
  public void handle(AssignA2ToPssPTIST3Event event) {
    LOGGER.info("handling AssignA2ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignA2(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignA2FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignA2FromPssPTIST3Event.class)
  public void handle(UnAssignA2FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignA2FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignA2(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignA3ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignA3ToPssPTIST3Event.class)
  public void handle(AssignA3ToPssPTIST3Event event) {
    LOGGER.info("handling AssignA3ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignA3(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignA3FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignA3FromPssPTIST3Event.class)
  public void handle(UnAssignA3FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignA3FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignA3(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignA4ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignA4ToPssPTIST3Event.class)
  public void handle(AssignA4ToPssPTIST3Event event) {
    LOGGER.info("handling AssignA4ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignA4(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignA4FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignA4FromPssPTIST3Event.class)
  public void handle(UnAssignA4FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignA4FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignA4(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignA5ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignA5ToPssPTIST3Event.class)
  public void handle(AssignA5ToPssPTIST3Event event) {
    LOGGER.info("handling AssignA5ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignA5(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignA5FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignA5FromPssPTIST3Event.class)
  public void handle(UnAssignA5FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignA5FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignA5(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignAlToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignAlToPssPTIST3Event.class)
  public void handle(AssignAlToPssPTIST3Event event) {
    LOGGER.info("handling AssignAlToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignAl(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignAlFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignAlFromPssPTIST3Event.class)
  public void handle(UnAssignAlFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignAlFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignAl(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignAthresToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignAthresToPssPTIST3Event.class)
  public void handle(AssignAthresToPssPTIST3Event event) {
    LOGGER.info("handling AssignAthresToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignAthres(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignAthresFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignAthresFromPssPTIST3Event.class)
  public void handle(UnAssignAthresFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignAthresFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignAthres(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignB0ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignB0ToPssPTIST3Event.class)
  public void handle(AssignB0ToPssPTIST3Event event) {
    LOGGER.info("handling AssignB0ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignB0(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignB0FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignB0FromPssPTIST3Event.class)
  public void handle(UnAssignB0FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignB0FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignB0(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignB1ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignB1ToPssPTIST3Event.class)
  public void handle(AssignB1ToPssPTIST3Event event) {
    LOGGER.info("handling AssignB1ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignB1(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignB1FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignB1FromPssPTIST3Event.class)
  public void handle(UnAssignB1FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignB1FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignB1(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignB2ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignB2ToPssPTIST3Event.class)
  public void handle(AssignB2ToPssPTIST3Event event) {
    LOGGER.info("handling AssignB2ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignB2(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignB2FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignB2FromPssPTIST3Event.class)
  public void handle(UnAssignB2FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignB2FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignB2(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignB3ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignB3ToPssPTIST3Event.class)
  public void handle(AssignB3ToPssPTIST3Event event) {
    LOGGER.info("handling AssignB3ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignB3(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignB3FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignB3FromPssPTIST3Event.class)
  public void handle(UnAssignB3FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignB3FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignB3(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignB4ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignB4ToPssPTIST3Event.class)
  public void handle(AssignB4ToPssPTIST3Event event) {
    LOGGER.info("handling AssignB4ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignB4(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignB4FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignB4FromPssPTIST3Event.class)
  public void handle(UnAssignB4FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignB4FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignB4(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignB5ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignB5ToPssPTIST3Event.class)
  public void handle(AssignB5ToPssPTIST3Event event) {
    LOGGER.info("handling AssignB5ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignB5(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignB5FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignB5FromPssPTIST3Event.class)
  public void handle(UnAssignB5FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignB5FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignB5(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignDlToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignDlToPssPTIST3Event.class)
  public void handle(AssignDlToPssPTIST3Event event) {
    LOGGER.info("handling AssignDlToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignDl(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignDlFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignDlFromPssPTIST3Event.class)
  public void handle(UnAssignDlFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignDlFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignDl(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignDtcToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignDtcToPssPTIST3Event.class)
  public void handle(AssignDtcToPssPTIST3Event event) {
    LOGGER.info("handling AssignDtcToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignDtc(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignDtcFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignDtcFromPssPTIST3Event.class)
  public void handle(UnAssignDtcFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignDtcFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignDtc(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignDtfToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignDtfToPssPTIST3Event.class)
  public void handle(AssignDtfToPssPTIST3Event event) {
    LOGGER.info("handling AssignDtfToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignDtf(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignDtfFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignDtfFromPssPTIST3Event.class)
  public void handle(UnAssignDtfFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignDtfFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignDtf(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignDtpToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignDtpToPssPTIST3Event.class)
  public void handle(AssignDtpToPssPTIST3Event event) {
    LOGGER.info("handling AssignDtpToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignDtp(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignDtpFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignDtpFromPssPTIST3Event.class)
  public void handle(UnAssignDtpFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignDtpFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignDtp(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignIswToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignIswToPssPTIST3Event.class)
  public void handle(AssignIswToPssPTIST3Event event) {
    LOGGER.info("handling AssignIswToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignIsw(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignIswFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignIswFromPssPTIST3Event.class)
  public void handle(UnAssignIswFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignIswFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignIsw(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignKToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignKToPssPTIST3Event.class)
  public void handle(AssignKToPssPTIST3Event event) {
    LOGGER.info("handling AssignKToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignK(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignKFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignKFromPssPTIST3Event.class)
  public void handle(UnAssignKFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignKFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignK(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignLthresToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignLthresToPssPTIST3Event.class)
  public void handle(AssignLthresToPssPTIST3Event event) {
    LOGGER.info("handling AssignLthresToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignLthres(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignLthresFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignLthresFromPssPTIST3Event.class)
  public void handle(UnAssignLthresFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignLthresFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignLthres(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignMToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignMToPssPTIST3Event.class)
  public void handle(AssignMToPssPTIST3Event event) {
    LOGGER.info("handling AssignMToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignM(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignMFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignMFromPssPTIST3Event.class)
  public void handle(UnAssignMFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignMFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignM(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignNavToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignNavToPssPTIST3Event.class)
  public void handle(AssignNavToPssPTIST3Event event) {
    LOGGER.info("handling AssignNavToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignNav(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignNavFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignNavFromPssPTIST3Event.class)
  public void handle(UnAssignNavFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignNavFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignNav(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignNclToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignNclToPssPTIST3Event.class)
  public void handle(AssignNclToPssPTIST3Event event) {
    LOGGER.info("handling AssignNclToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignNcl(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignNclFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignNclFromPssPTIST3Event.class)
  public void handle(UnAssignNclFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignNclFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignNcl(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignNcrToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignNcrToPssPTIST3Event.class)
  public void handle(AssignNcrToPssPTIST3Event event) {
    LOGGER.info("handling AssignNcrToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignNcr(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignNcrFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignNcrFromPssPTIST3Event.class)
  public void handle(UnAssignNcrFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignNcrFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignNcr(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignPminToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignPminToPssPTIST3Event.class)
  public void handle(AssignPminToPssPTIST3Event event) {
    LOGGER.info("handling AssignPminToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignPmin(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignPminFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignPminFromPssPTIST3Event.class)
  public void handle(UnAssignPminFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignPminFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignPmin(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignT1ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignT1ToPssPTIST3Event.class)
  public void handle(AssignT1ToPssPTIST3Event event) {
    LOGGER.info("handling AssignT1ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignT1(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignT1FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignT1FromPssPTIST3Event.class)
  public void handle(UnAssignT1FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignT1FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignT1(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignT2ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignT2ToPssPTIST3Event.class)
  public void handle(AssignT2ToPssPTIST3Event event) {
    LOGGER.info("handling AssignT2ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignT2(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignT2FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignT2FromPssPTIST3Event.class)
  public void handle(UnAssignT2FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignT2FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignT2(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignT3ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignT3ToPssPTIST3Event.class)
  public void handle(AssignT3ToPssPTIST3Event event) {
    LOGGER.info("handling AssignT3ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignT3(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignT3FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignT3FromPssPTIST3Event.class)
  public void handle(UnAssignT3FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignT3FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignT3(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignT4ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignT4ToPssPTIST3Event.class)
  public void handle(AssignT4ToPssPTIST3Event event) {
    LOGGER.info("handling AssignT4ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignT4(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignT4FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignT4FromPssPTIST3Event.class)
  public void handle(UnAssignT4FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignT4FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignT4(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignT5ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignT5ToPssPTIST3Event.class)
  public void handle(AssignT5ToPssPTIST3Event event) {
    LOGGER.info("handling AssignT5ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignT5(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignT5FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignT5FromPssPTIST3Event.class)
  public void handle(UnAssignT5FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignT5FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignT5(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignT6ToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignT6ToPssPTIST3Event.class)
  public void handle(AssignT6ToPssPTIST3Event event) {
    LOGGER.info("handling AssignT6ToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignT6(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignT6FromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignT6FromPssPTIST3Event.class)
  public void handle(UnAssignT6FromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignT6FromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignT6(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignTfToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignTfToPssPTIST3Event.class)
  public void handle(AssignTfToPssPTIST3Event event) {
    LOGGER.info("handling AssignTfToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignTf(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignTfFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignTfFromPssPTIST3Event.class)
  public void handle(UnAssignTfFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignTfFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignTf(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event AssignTpToPssPTIST3Event
   */
  @EventHandler(payloadType = AssignTpToPssPTIST3Event.class)
  public void handle(AssignTpToPssPTIST3Event event) {
    LOGGER.info("handling AssignTpToPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssPTIST3 entity = assignTp(event.getPssPTIST3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /*
   * @param	event UnAssignTpFromPssPTIST3Event
   */
  @EventHandler(payloadType = UnAssignTpFromPssPTIST3Event.class)
  public void handle(UnAssignTpFromPssPTIST3Event event) {
    LOGGER.info("handling UnAssignTpFromPssPTIST3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssPTIST3 entity = unAssignTp(event.getPssPTIST3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssPTIST3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssPTIST3(entity);
  }

  /**
   * Method to retrieve the PssPTIST3 via an PssPTIST3PrimaryKey.
   *
   * @param id Long
   * @return PssPTIST3
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssPTIST3 handle(FindPssPTIST3Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssPTIST3Id());
  }

  /**
   * Method to retrieve a collection of all PssPTIST3s
   *
   * @param query FindAllPssPTIST3Query
   * @return List<PssPTIST3>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssPTIST3> handle(FindAllPssPTIST3Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssPTIST3, but only if the id matches
   *
   * @param entity PssPTIST3
   */
  protected void emitFindPssPTIST3(PssPTIST3 entity) {
    LOGGER.info("handling emitFindPssPTIST3");

    queryUpdateEmitter.emit(
        FindPssPTIST3Query.class,
        query -> query.getFilter().getPssPTIST3Id().equals(entity.getPssPTIST3Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssPTIST3
   *
   * @param entity PssPTIST3
   */
  protected void emitFindAllPssPTIST3(PssPTIST3 entity) {
    LOGGER.info("handling emitFindAllPssPTIST3");

    queryUpdateEmitter.emit(FindAllPssPTIST3Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssPTIST3Projector.class.getName());
}
