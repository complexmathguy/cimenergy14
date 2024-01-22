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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * PerLengthDCLineParameter business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PerLengthDCLineParameter related services in the case of a
 *       PerLengthDCLineParameter business related service failing.
 *   <li>Exposes a simpler, uniform PerLengthDCLineParameter interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PerLengthDCLineParameter
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PerLengthDCLineParameterBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PerLengthDCLineParameterBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PerLengthDCLineParameter Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PerLengthDCLineParameterBusinessDelegate
   */
  public static PerLengthDCLineParameterBusinessDelegate getPerLengthDCLineParameterInstance() {
    return (new PerLengthDCLineParameterBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPerLengthDCLineParameter(
      CreatePerLengthDCLineParameterCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPerLengthDCLineParameterId() == null)
        command.setPerLengthDCLineParameterId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePerLengthDCLineParameterCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePerLengthDCLineParameterCommand of PerLengthDCLineParameter is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PerLengthDCLineParameter - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePerLengthDCLineParameterCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePerLengthDCLineParameter(
      UpdatePerLengthDCLineParameterCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePerLengthDCLineParameterCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PerLengthDCLineParameter - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePerLengthDCLineParameterCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePerLengthDCLineParameterCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePerLengthDCLineParameterCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PerLengthDCLineParameter using Id = "
              + command.getPerLengthDCLineParameterId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PerLengthDCLineParameter via PerLengthDCLineParameterFetchOneSummary
   *
   * @param summary PerLengthDCLineParameterFetchOneSummary
   * @return PerLengthDCLineParameterFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PerLengthDCLineParameter getPerLengthDCLineParameter(
      PerLengthDCLineParameterFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PerLengthDCLineParameterFetchOneSummary arg cannot be null");

    PerLengthDCLineParameter entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PerLengthDCLineParameter
      // --------------------------------------
      CompletableFuture<PerLengthDCLineParameter> futureEntity =
          queryGateway.query(
              new FindPerLengthDCLineParameterQuery(
                  new LoadPerLengthDCLineParameterFilter(summary.getPerLengthDCLineParameterId())),
              ResponseTypes.instanceOf(PerLengthDCLineParameter.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PerLengthDCLineParameter with id "
              + summary.getPerLengthDCLineParameterId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PerLengthDCLineParameters
   *
   * @return List<PerLengthDCLineParameter>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PerLengthDCLineParameter> getAllPerLengthDCLineParameter()
      throws ProcessingException {
    List<PerLengthDCLineParameter> list = null;

    try {
      CompletableFuture<List<PerLengthDCLineParameter>> futureList =
          queryGateway.query(
              new FindAllPerLengthDCLineParameterQuery(),
              ResponseTypes.multipleInstancesOf(PerLengthDCLineParameter.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PerLengthDCLineParameter";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Capacitance on PerLengthDCLineParameter
   *
   * @param command AssignCapacitanceToPerLengthDCLineParameterCommand
   * @exception ProcessingException
   */
  public void assignCapacitance(AssignCapacitanceToPerLengthDCLineParameterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPerLengthDCLineParameterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CapacitancePerLengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance();
    PerLengthDCLineParameterBusinessDelegate parentDelegate =
        PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance();
    UUID childId = command.getAssignment().getCapacitancePerLengthId();
    CapacitancePerLength child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CapacitancePerLength using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Capacitance on PerLengthDCLineParameter
   *
   * @param command UnAssignCapacitanceFromPerLengthDCLineParameterCommand
   * @exception ProcessingException
   */
  public void unAssignCapacitance(UnAssignCapacitanceFromPerLengthDCLineParameterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Capacitance on PerLengthDCLineParameter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Inductance on PerLengthDCLineParameter
   *
   * @param command AssignInductanceToPerLengthDCLineParameterCommand
   * @exception ProcessingException
   */
  public void assignInductance(AssignInductanceToPerLengthDCLineParameterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPerLengthDCLineParameterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .InductancePerLengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .InductancePerLengthBusinessDelegate.getInductancePerLengthInstance();
    PerLengthDCLineParameterBusinessDelegate parentDelegate =
        PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance();
    UUID childId = command.getAssignment().getInductancePerLengthId();
    InductancePerLength child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get InductancePerLength using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Inductance on PerLengthDCLineParameter
   *
   * @param command UnAssignInductanceFromPerLengthDCLineParameterCommand
   * @exception ProcessingException
   */
  public void unAssignInductance(UnAssignInductanceFromPerLengthDCLineParameterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Inductance on PerLengthDCLineParameter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Resistance on PerLengthDCLineParameter
   *
   * @param command AssignResistanceToPerLengthDCLineParameterCommand
   * @exception ProcessingException
   */
  public void assignResistance(AssignResistanceToPerLengthDCLineParameterCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPerLengthDCLineParameterId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistancePerLengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistancePerLengthBusinessDelegate.getResistancePerLengthInstance();
    PerLengthDCLineParameterBusinessDelegate parentDelegate =
        PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance();
    UUID childId = command.getAssignment().getResistancePerLengthId();
    ResistancePerLength child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ResistancePerLength using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Resistance on PerLengthDCLineParameter
   *
   * @param command UnAssignResistanceFromPerLengthDCLineParameterCommand
   * @exception ProcessingException
   */
  public void unAssignResistance(UnAssignResistanceFromPerLengthDCLineParameterCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PerLengthDCLineParameterValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Resistance on PerLengthDCLineParameter";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PerLengthDCLineParameter
   */
  private PerLengthDCLineParameter load(UUID id) throws ProcessingException {
    perLengthDCLineParameter =
        PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
            .getPerLengthDCLineParameter(new PerLengthDCLineParameterFetchOneSummary(id));
    return perLengthDCLineParameter;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PerLengthDCLineParameter perLengthDCLineParameter = null;
  private static final Logger LOGGER =
      Logger.getLogger(PerLengthDCLineParameterBusinessDelegate.class.getName());
}
