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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator.*;
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
 * BaseVoltage business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of BaseVoltage related services in the case of a BaseVoltage
 *       business related service failing.
 *   <li>Exposes a simpler, uniform BaseVoltage interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill BaseVoltage business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class BaseVoltageBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public BaseVoltageBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * BaseVoltage Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return BaseVoltageBusinessDelegate
   */
  public static BaseVoltageBusinessDelegate getBaseVoltageInstance() {
    return (new BaseVoltageBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createBaseVoltage(CreateBaseVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getBaseVoltageId() == null) command.setBaseVoltageId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      BaseVoltageValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateBaseVoltageCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateBaseVoltageCommand of BaseVoltage is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create BaseVoltage - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateBaseVoltageCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateBaseVoltage(UpdateBaseVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      BaseVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateBaseVoltageCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save BaseVoltage - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteBaseVoltageCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteBaseVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BaseVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteBaseVoltageCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete BaseVoltage using Id = " + command.getBaseVoltageId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the BaseVoltage via BaseVoltageFetchOneSummary
   *
   * @param summary BaseVoltageFetchOneSummary
   * @return BaseVoltageFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public BaseVoltage getBaseVoltage(BaseVoltageFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("BaseVoltageFetchOneSummary arg cannot be null");

    BaseVoltage entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      BaseVoltageValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a BaseVoltage
      // --------------------------------------
      CompletableFuture<BaseVoltage> futureEntity =
          queryGateway.query(
              new FindBaseVoltageQuery(new LoadBaseVoltageFilter(summary.getBaseVoltageId())),
              ResponseTypes.instanceOf(BaseVoltage.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate BaseVoltage with id " + summary.getBaseVoltageId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all BaseVoltages
   *
   * @return List<BaseVoltage>
   * @exception ProcessingException Thrown if any problems
   */
  public List<BaseVoltage> getAllBaseVoltage() throws ProcessingException {
    List<BaseVoltage> list = null;

    try {
      CompletableFuture<List<BaseVoltage>> futureList =
          queryGateway.query(
              new FindAllBaseVoltageQuery(), ResponseTypes.multipleInstancesOf(BaseVoltage.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all BaseVoltage";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign NominalVoltage on BaseVoltage
   *
   * @param command AssignNominalVoltageToBaseVoltageCommand
   * @exception ProcessingException
   */
  public void assignNominalVoltage(AssignNominalVoltageToBaseVoltageCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getBaseVoltageId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    BaseVoltageBusinessDelegate parentDelegate =
        BaseVoltageBusinessDelegate.getBaseVoltageInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      BaseVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NominalVoltage on BaseVoltage
   *
   * @param command UnAssignNominalVoltageFromBaseVoltageCommand
   * @exception ProcessingException
   */
  public void unAssignNominalVoltage(UnAssignNominalVoltageFromBaseVoltageCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BaseVoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NominalVoltage on BaseVoltage";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return BaseVoltage
   */
  private BaseVoltage load(UUID id) throws ProcessingException {
    baseVoltage =
        BaseVoltageBusinessDelegate.getBaseVoltageInstance()
            .getBaseVoltage(new BaseVoltageFetchOneSummary(id));
    return baseVoltage;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private BaseVoltage baseVoltage = null;
  private static final Logger LOGGER =
      Logger.getLogger(BaseVoltageBusinessDelegate.class.getName());
}
